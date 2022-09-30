package shoppping_cart.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shoppping_cart.dto.CartDto;
import shoppping_cart.dto.ProductDto;
import shoppping_cart.model.Product;
import shoppping_cart.service.IProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")//khai báo session tên là cart
@Controller
@RequestMapping("/shop")
public class ProductController {

    /* khởi tạo giá trị mặc định cho session */
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showShop(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") int idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        model.addAttribute("productList", productService.findAll());
        return "list";
    }

    @GetMapping("/view/{id}")
    public String showProduct(@PathVariable int id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60 * 60 * 24 * 1); //thời gian tồn tại của cookie trong 1 ngày
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("productList", productService.findById(id).get());
        return "view";
    }

    @GetMapping("/add/{id}")
    public String addProductToCard(@PathVariable int id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = productService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String removeProduct(@PathVariable int id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDelete = productService.findById(id);
        if (productDelete.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDelete.get(), productDto);
            cart.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/deleteAll/{id}")
    public String removeAll(@PathVariable int id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productDeleteAll = productService.findById(id);
        if (productDeleteAll.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDeleteAll.get(), productDto);
            cartDto.deleteAllProduct(productDto);
        }
        return "redirect:/cart";
    }
}
