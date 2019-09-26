package edu.neu.ccs.cs6650.Servlet;

import com.google.gson.Gson;
import edu.neu.ccs.cs6650.Model.Resort;
import edu.neu.ccs.cs6650.Model.ResortsList;
import edu.neu.ccs.cs6650.Model.SeasonsList;
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
@WebServlet(name = "ResortServlet", urlPatterns = "/resorts")
public class ResortServlet extends HttpServlet {

  private static final Logger logger = LogManager.getLogger(ResortServlet.class.getName());
  /*

  /resorts [GET]

  /resorts/{resortID}/seasons [GET]

  /resorts/{resortID}/seasons [POST]
    { "year": 2019 }

   */
  protected void doPost(HttpServletRequest req,
      HttpServletResponse res)
      throws ServletException, IOException {
    res.setContentType("application/json");
    res.setCharacterEncoding("UTF-8");

    String urlPath = req.getRequestURI();
    logger.info(req.getRequestURI());

    if (urlPath == null || urlPath.isEmpty()) {
      res.setStatus(HttpServletResponse.SC_NOT_FOUND);
      res.getWriter().write("missing parameters");
      return;
    }

    // TODO: persist to DB
    res.setStatus(HttpServletResponse.SC_OK);
    res.getWriter().write("Roger that");
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
      response = retrieveAllResorts();
    } else if (urlParts.length == 5) {
      int resortId = Integer.valueOf(urlParts[3]);
      response = retrieveSeasonListByResort(resortId);
    }

    PrintWriter out = res.getWriter();
    out.print(response);
    out.flush();
  }

  // demo method for testing returning json
  private String retrieveAllResorts() {
    Gson gson = new Gson();

    List<Resort> dummy = new ArrayList<>();
      dummy.add(new Resort("resort1", 1));
      dummy.add(new Resort("resort2", 2));

    ResortsList resorts = new ResortsList(dummy);

    return gson.toJson(resorts);
  }

  private String retrieveSeasonListByResort(int resortId) {
    Gson gson = new Gson();
    SeasonsList seasons = new SeasonsList(Arrays.asList("2017", "2018", "2019"));

    return gson.toJson(seasons);
  }

  private boolean isUrlValid(String[] urlPath) {
    // TODO: validate the request url path according to the API spec
    if (!(urlPath.length == 3 || urlPath.length == 5)) return false;

    return true;
  }
}