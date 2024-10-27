"use strict";
const express = require("express");
const router = express.Router();

router.get("/", (req, res, next) => {
  res.render("index");
});
router.get("/products", (req, res, next) => {
  res.render("products");
});
router.get("/sales", (req, res, next) => {
  res.render("sales");
});
router.get("/clients", (req, res, next) => {
  res.render("clients");
});
router.get("/providers", (req, res, next) => {
  res.render("providers");
});
router.get("/warehouses", (req, res, next) => {
  res.render("warehouses");
});
router.get("/workers", (req, res, next) => {
  res.render("workers");
});

module.exports = router;
