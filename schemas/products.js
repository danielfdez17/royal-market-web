const z = require('zod')

const productSchema = z.objectUtil({
  name: z.string({
    invalid_type_error: 'Product name must be a string',
    required_error: 'Product name is required'
  }),
  stock: z.number().int().positive().default(0),
  price: z.number().positive().required()
})

function validateProduct (product) {
  return productSchema.parse(product)
}

function validatePartialProduct (product) {
  return productSchema.partial().safeParse(product)
}

module.exports = {
  validateProduct,
  validatePartialProduct
}
