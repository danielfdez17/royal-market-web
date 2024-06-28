const daoProducts = require("../db/DAOProducts.js");

class ProductsController {
  static async getAll(req, res) {
    const products = await daoProducts.getAll();
    res.render("products", { products });
    // res.status(200).json(products);
  }

  static async getById(req, res) {
    const { id } = req.params;
    const product = await daoProducts.getById({ id });
    if (product) {
      return res.status(200).json(product);
    }
    res.status(404).json({ msg: "Product not found" });
  }

  static async create(req, res) {
    // const result = validateProduct(req.body);

    // if (result.error) {
    //   res.status(400).json({ msg: JSON.parse(result.error.message) });
    // }

    const newProduct = await daoProducts.create({ input: result.data });

    res.status(201).json(newProduct);
  }

  static async delete(res, req) {
    const { id } = req.params;

    const result = await daoProducts.delete({ id });

    if (result === false) {
      return res.status(404).json({ msg: "Product not found" });
    }

    return res.json({ msg: "Product deleted" });
  }

  static async update(req, res) {
    // const result = validatePartialProduct(req.body);

    // if (!result.success) {
    //   return res.status(404).json({ msg: JSON.parse(result.error.message) });
    // }

    const { id } = req.params;

    const updatedProduct = await daoProducts.update({
      id,
      input: result.data,
    });

    return res.json(updatedProduct);
  }
}

module.exports = ProductsController;
