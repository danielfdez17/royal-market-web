"use strict";
const productsDAO = require("../db/productsDAO.js");

const dao = new productsDAO();

class productsController {
  readAll(req, res, next) {
    dao.readAll((err, products) => {
      if (err) {
        next(err);
      } else {
        console.log(products);
        res.render("products", { products: products });
      }
    });
  }
}

module.exports = productsController;
