"use strict";
const productsDAO = require("../../db/productsDAO.js");
const assert = require("assert");

const dao = new productsDAO();

describe("Testing products entity", () => {
  describe("readAll()", () => {
    it("readAll()", () => {
      dao.readAll((err, products) => {
        assert.notEqual(products.length, 0);
      });
    });
  });
});
