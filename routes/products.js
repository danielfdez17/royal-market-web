const express = require("express");

const productsController = require("../controllers/products.js");
const productsRouter = express.Router();

productsRouter.get("/", productsController.getAll);
productsRouter.get("/:id", productsController.getById);
productsRouter.post("/", productsController.create);
productsRouter.patch("/:id", productsController.update);
productsRouter.delete("/:id", productsController.delete);

module.exports = productsRouter;