package edu.neu.ccs.cs6650.Servlet;

import com.google.gson.Gson;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("Duplicates")
@WebServlet(name = "SkierServlet", urlPatterns = "/skiers")
public class SkierServlet extends HttpServlet {

  private static final Logger logger = LogManager.getLogger(SkierServlet.class.getName());
  /*



  /skiers/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID} [GET]

  /skiers/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID} [POST]
    {
      "time": 217,
      "liftID: 21
    }

  /skiers/{skierID}/vertical [GET]
    {
      "resorts": [
        {
          "seasonID": "string",
          "totalVert": 0
        }
      ]
    }

   */
  protected void doPost(HttpServletRequest req,
      HttpServletResponse res)
      throws ServletException, IOException {
    res.setContentType("application/json");
    res.setCharacterEncoding("UTF-8");

    String urlPath = req.getRequestURI();
    logger.info(req.getRequestURI());
    logger.info("time: " + req.getParameter("time"));

    if (urlPath == null || urlPath.isEmpty()) {
      res.setStatus(HttpServletResponse.SC_NOT_FOUND);
      res.getWriter().write("missing parameters");
      return;
    }

    // TODO: persist to DB
    res.setStatus(HttpServletResponse.SC_OK);
    String response = "{success: 0}";
    PrintWriter out = res.getWriter();
    out.print(response);
    out.flush();
  }

  protected void doGet(HttpServletRequest req,
      HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("application/json");
    res.setCharacterEncoding("UTF-8");

    String urlPath = req.getRequestURI();

    logger.info(req.getRequestURI());

    // check we have a URL!
    if (urlPath == null || urlPath.isEmpty()) {
      res.setStatus(HttpServletResponse.SC_NOT_FOUND);
      res.getWriter().write("missing parameters");
      return;
    }

    String[] urlParts = urlPath.split("/");

    // and now validate url path and return the response status code
    // (and maybe also some value if input is valid)

    if (!isUrlValid(urlParts)) {
      res.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    res.setStatus(HttpServletResponse.SC_OK);

    String response = "";

    if (urlParts.length == 3) { // request for all resorts

    } else if (urlParts.length == 5) {


    }

    PrintWriter out = res.getWriter();
    out.print(response);
    out.flush();

  }


  private boolean isUrlValid(String[] urlPath) {
    // TODO: validate the request url path according to the API spec
    if (!(urlPath.length == 3 || urlPath.length == 5)) return false;

    return true;
  }
}