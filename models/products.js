'use strict'
const pool = require('../db/pool.js')
const DAOProducts = require('../db/DAOProducts.js')
const { validateProduct, validatePartialProduct } = require('../schemas/products.js')

const daoProducts = new DAOProducts(pool)

export class ProductsModel {
  static async create ({ input }) {}
  static async getById ({ id }) {}
  static async getAll () {}
  static async update ({ id, input }) {}
  static async delete ({ id }) {}
}
