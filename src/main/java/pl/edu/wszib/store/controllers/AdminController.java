package pl.edu.wszib.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.store.model.Product;
import pl.edu.wszib.store.model.User;
import pl.edu.wszib.store.model.Order;
import pl.edu.wszib.store.model.OrderPosition;
import pl.edu.wszib.store.services.IOrderService;
import pl.edu.wszib.store.services.IProductService;
import pl.edu.wszib.store.session.SessionObject;
import java.util.List;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Autowired
    IProductService productService;

    @Autowired
    IOrderService orderService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable int id, Model model) {
        if(!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        Product product = this.productService.getProductById(id);

        model.addAttribute("product", product);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@ModelAttribute Product product) {
        if(!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }

        this.productService.updateProduct(product);

        return "redirect:/main";
    }

    @RequestMapping(value = "/cheat-for-record-order", method = RequestMethod.GET)
    public String zapis() {

        List<Product> books = this.productService.getAllProducts();

        Order order = new Order();
        order.setStatus(Order.Status.ORDERED);
        order.setUser(this.sessionObject.getLoggedUser());

        OrderPosition orderPosition1 = new OrderPosition();
        orderPosition1.setQuan(1);
        orderPosition1.setProduct(books.get(0));
        orderPosition1.setOrder(order);

        order.getPositions().add(orderPosition1);

        OrderPosition orderPosition2 = new OrderPosition();
        orderPosition2.setQuan(2);
        orderPosition2.setProduct(books.get(1));
        orderPosition2.setOrder(order);

        order.getPositions().add(orderPosition2);
        order.setPrice(books.get(0).getPrice() + books.get(1).getPrice() * 2);

        this.orderService.saveOrder(order);

        return "redirect:/main";
    }

    @RequestMapping(value = "/cheat-for-record-order", method = RequestMethod.GET)
    public String odczyt() {

        Order order = this.orderService.getOrderById(1);

        System.out.println(order);

        return "redirect:/main";
    }
}
