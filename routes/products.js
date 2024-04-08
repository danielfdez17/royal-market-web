import { Router } from 'express'

import { ProductsController } from '../controllers/products.js'

export const productsRouter = Router()

productsRouter.get('/', ProductsController.getAll)
productsRouter.get('/:id', ProductsController.getById)
productsRouter.post('/', ProductsController.create)
productsRouter.patch('/:id', ProductsController.update)
productsRouter.delete('/:id', ProductsController.delete)
