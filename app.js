require("dotenv").config();
const createError = require("http-errors");
const express = require("express");
const path = require("path");
const database = require("./db/pool.js");

module.exports = {
  pool: database.pool,
};

const PORT = process.env.PORT || 3000;

const indexRouter = require("./routes/indexRouter.js");
// const warehousesRouter = require('./routes/users.js')
// const clientsRouter = require('./routes/clients.js')
// const salesRouter = require('./routes/sales.js')
// const productsRouter = require('./routes/products.js')
// const providersRouter = require('./routes/providers.js')
// const workersRouter = require('./routes/workers.js')

const app = express();

app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, "public")));

app.use("/", indexRouter);
// app.use('/warehouses', warehousesRouter)
// app.use('/clients', clientsRouter)
// app.use('/sales', salesRouter)
// app.use('/products', productsRouter)
// app.use('/providers', providersRouter)
// app.use('/workers', workersRouter)

// catch 404 and forward to error handler
app.use((req, res, next) => {
  next(createError(404));
});

app.use((err, req, res, next) => {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get("env") === "development" ? err : {};
  // render the error page
  res.status(err.status || 500);
  res.render("error");
});

app.listen(PORT, (err) => {
  if (err) {
    console.error("Error when starting the server: " + err);
  } else {
    console.log(`Server is listening on port http://localhost:${PORT}`);
  }
});
