"use strict";
const express = require("express");
const router = express.Router();
const productsController = require("../controllers/products.js");

const controller = new productsController();

router.get("/", controller.readAll);

module.exports = router;
