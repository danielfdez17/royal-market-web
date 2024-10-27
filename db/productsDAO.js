"use strict";
const pool = require("./pool.js");

class productsDAO {
  readAll(callback) {
    // console.log(pool);
    pool.getConnection((err, connection) => {
      if (err) {
        callback(err);
      } else {
        const sql = "SELECT * FROM products";
        pool.query(sql, (err, rows) => {
          connection.release();
          if (err) {
            callback(err);
          } else {
            console.log(rows);
            callback(null, rows);
            return rows;
          }
        });
      }
    });
  }
}

module.exports = productsDAO;
