import { objectUtil, string, number } from "zod";

const productSchema = objectUtil({
  name: string({
    invalid_type_error: "Product name must be a string",
    required_error: "Product name is required",
  }),
  stock: number().int().positive().default(0),
  price: number().positive().required(),
});

function validateProduct(product) {
  return productSchema.parse(product);
}

function validatePartialProduct(product) {
  return productSchema.partial().safeParse(product);
}

export default {
  validateProduct,
  validatePartialProduct,
};
