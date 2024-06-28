// class DAOProducts {
//   pool;

//   constructor(pool) {
//     this.pool = pool;
//   }

//   create(product, callback) {
//     this.pool.getConnection((err, connection) => {
//       if (err) {
//         callback(err);
//       } else {
//         connection.query(
//           "INSERT INTO products (name, stock, price) VALUES (?, ?, ?)",
//           [product.name, product.stock, product.price],
//           (err, rows) => {
//             if (err) {
//               callback(err);
//             } else callback(null, rows[0]);
//             connection.release();
//           }
//         );
//       }
//     });
//   }

//   getById(id, callback) {
//     this.pool.getConnection((err, connection) => {
//       if (err) {
//         callback(err);
//       } else {
//         connection.query(
//           "SELECT * FROM products WHERE id = ?",
//           [id],
//           (err, rows) => {
//             if (err) {
//               callback(err);
//             } else {
//               callback(null, rows[0]);
//             }
//             connection.release();
//           }
//         );
//       }
//     });
//   }

//   // getAll() {
//   //   this.pool.getConnection((err, connection) => {
//   //     if (err) {
//   //       console.log(err);
//   //       // callback(err);
//   //     } else {
//   //       connection.query("SELECT * FROM products", (err, rows) => {
//   //         if (err) {
//   //           console.log(err);
//   //           // callback(err);
//   //         } else {
//   //           // callback(null, rows);
//   //           return rows;
//   //         }
//   //         connection.release();
//   //       });
//   //     }
//   //   });
//   // }

//   update(product, callback) {
//     this.pool.getConnection((err, connection) => {
//       if (err) {
//         callback(err);
//       } else {
//         connection.query(
//           "UPDATE products SET name = ?, stock = ?, price = ? WHERE id = ?",
//           [product.name, product.stock, product.price, product.id],
//           (err, rows) => {
//             if (err) {
//               callback(err);
//             } else callback(null, rows);
//             connection.release();
//           }
//         );
//       }
//     });
//   }

//   delete(id, callback) {
//     this.pool.getConnection((err, connection) => {
//       if (err) {
//         callback(err);
//       } else {
//         connection.query(
//           "UPDATE products SET activo = 0 WHERE id = ?",
//           [id],
//           (err, rows) => {
//             if (err) {
//               callback(err);
//             } else callback(null, rows);
//             connection.release();
//           }
//         );
//       }
//     });
//   }
// }

const pool = require("./pool.js");

exports.getAll = (req, res) => {
  pool.getConnection((err, connection) => {
    if (err) {
      console.log(err);
      // callback(err);
    } else {
      connection.query("SELECT * FROM products", (err, rows) => {
        if (err) {
          console.log(err);
          // callback(err);
        } else {
          // callback(null, rows);
          return rows;
        }
        connection.release();
      });
    }
  });
};

// module.exports = DAOProducts;
