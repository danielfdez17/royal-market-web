import { ProductsModel } from '../models/products.js'
import { validateProduct, validatePartialProduct } from '../schemas/products.js'

export class ProductsController {
  static async getAll (req, res) {
    const products = await ProductsModel.getAll()
    res.status(200).json(products)
  }

  static async getById (req, res) {
    const { id } = req.params
    const product = await ProductsModel.getById({ id })
    if (product) { return res.status(200).json(product) }
    res.status(404).json({ msg: 'Product not found' })
  }

  static async create (req, res) {
    const result = validateProduct(req.body)

    if (result.error) { res.status(400).json({ msg: JSON.parse(result.error.message) }) }

    const newProduct = await ProductsModel.create({ input: result.data })

    res.status(201).json(newProduct)
  }

  static async delete (res, req) {
    const { id } = req.params

    const result = await ProductsModel.delete({ id })

    if (result === false) { return res.status(404).json({ msg: 'Product not found' }) }

    return res.json({ msg: 'Product deleted' })
  }

  static async update (req, res) {
    const result = validatePartialProduct(req.body)

    if (!result.success) { return res.status(404).json({ msg: JSON.parse(result.error.message) }) }

    const { id } = req.params

    const updatedProduct = await ProductsModel.update({ id, input: result.data })

    return res.json(updatedProduct)
  }
}
