const express = require("express");
const router = express.Router();

router.get("/", (req, res, next) => {
  res.render("index");
});
router.get("/products", (req, res, next) => {
  res.render("products");
});

module.exports = router;
