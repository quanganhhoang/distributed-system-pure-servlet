package edu.neu.ccs.cs6650.Servlet;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest req,
      HttpServletResponse res)
      throws ServletException, IOException {

    res.setContentType("application/json");
    res.setCharacterEncoding("UTF-8");
    String urlPath = req.getPathInfo();
//    String urlPath = req.getRequestURI();
//    String urlPath = req.getServletPath();

    logger.info(urlPath);
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
    } else {
      res.setStatus(HttpServletResponse.SC_OK);
      // do any sophisticated processing with urlParts which contains all the url params
      // TODO: process url params in `urlParts`
      String response = "{'name' : 'qa'}";
//      String jsonString = new Gson().toJson(response);
      PrintWriter out = res.getWriter();
//      out.print(jsonString);
      out.print(response);
      out.flush();
    }
  }

  private boolean isUrlValid(String[] urlPath) {
    // TODO: validate the request url path according to the API spec
    // urlPath  = "/1/seasons/2019/day/1/skier/123"
    // urlParts = [, 1, seasons, 2019, day, 1, skier, 123]
    return true;
  }
}