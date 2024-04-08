export class DAOProducts {
  pool

  constructor (pool) {
    this.pool = pool
  }

  create ({ input }, callback) {
    this.pool.getConnection((err, connection) => {
      if (err) { callback(err) } else {
        connection.query(
          'INSERT INTO products (name, stock, price) VALUES (?, ?, ?)',
          [input.name, input.stock, input.price],
          (err, rows) => {
            if (err) { callback(err) } else callback(null, rows[0])
            connection.release()
          }
        )
      }
    })
  }

  getById ({ id }, callback) {
    this.pool.getConnection((err, connection) => {
      if (err) { callback(err) } else {
        connection.query(
          'SELECT * FROM products WHERE id = ?',
          [id],
          (err, rows) => {
            if (err) { callback(err) } else { callback(null, rows[0]) }
            connection.release()
          }
        )
      }
    })
  }

  getAll (callback) {
    this.pool.getConnection((err, connection) => {
      if (err) { callback(err) } else {
        connection.query('SELECT * FROM products', (err, rows) => {
          if (err) { callback(err) } else { callback(null, rows) }
          connection.release()
        })
      }
    })
  }

  update ({ id, input }, callback) {
    this.pool.getConnection((err, connection) => {
      if (err) { callback(err) } else {
        connection.query(
          'UPDATE products SET name = ?, stock = ?, price = ? WHERE id = ?',
          [input.name, input.stock, input.price, id],
          (err, rows) => {
            if (err) { callback(err) } else callback(null, rows)
            connection.release()
          }
        )
      }
    })
  }

  delete ({ id }, callback) {
    this.pool.getConnection((err, connection) => {
      if (err) { callback(err) } else {
        connection.query(
          'DELETE FROM products WHERE id = ?',
          [id],
          (err, rows) => {
            if (err) { callback(err) } else callback(null, rows)
            connection.release()
          }
        )
      }
    })
  }
}
