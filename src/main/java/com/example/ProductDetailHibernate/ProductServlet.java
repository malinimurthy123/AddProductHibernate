package com.example.ProductDetailHibernate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(name= "ProductServlet", value= "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Session theSession;

    SessionFactory theFactory;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Auto-generated method stub

        SessionFactory theFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
            theSession =theFactory.getCurrentSession();
            //theSession = factory.openSession();
            try {
                theSession.beginTransaction();
            }
            finally {
//   		theFactory.close();
            }

            // using HQL
            List<Product> list = theSession.createQuery("from Product", Product.class).getResultList();


            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<b>Product Listing</b><br>");
            for (Product productList : list) {
                System.out.println(productList.getName());
                out.println("ID: " + String.valueOf(productList.getID()) + ", ProductName: " + productList.getName() +
                        ", Price: " + String.valueOf(productList.getPrice()) + ", Colour: " + productList.getColor().toString() + "<br>");
            }
            out.println("<a href='index.jsp'>Return to homepage</a><br>");
            out.println("</body></html>");


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        SessionFactory theFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session theSession =theFactory.getCurrentSession();
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<b>Adding Product</b> " + request.getParameter("ProductName") + "<br>");
        out.println("<b>Adding Product</b> " + request.getParameter("price") + "<br>");
        out.println("<b>Adding Product</b> " + request.getParameter("Colour") + "<br>");


        out.println("<a href='index.jsp'>Return to Main</a><br>");
        out.println("</body></html>");

        String name = request.getParameter("ProductName");
        String color = request.getParameter("Colour");
        String price = request.getParameter("price");

        /*if (name == null || name.equals("")) {
            out.println("<p>Product name is required.</p>");
        } else if (color == null || color.equals("")) {
            out.println("<p>Product color is required.</p>");
        } else if (price == null || price.equals("")) {
            out.println("<p>Product price is required.</p>");
        } else {*/


            BigDecimal newPrice= new BigDecimal(price);

            Product product = new Product();
            product.setName(name);
            product.setColor(color);
            product.setPrice(newPrice);

            theSession.beginTransaction();
            System.out.println("Object Saved");
            theSession.save(product);
            System.out.println("Object Saved");
            out.println("<p>Product added.</p>");

        //}
        out.println("<a href='addpet.jsp'>Add New Pet</a><br>");
        out.println("<a href='index.jsp'>Return to Main</a><br>");
        out.println("</body></html>");

    }

}