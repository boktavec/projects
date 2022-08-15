import express from "express";
import bodyParser from "body-parser";
import mongoose from "mongoose";
import cors from "cors";
import "dotenv/config";

import postRoutes from "./routes/posts.js";

const app = express();

app.use("/posts", postRoutes);

const DB_CONNECTION = process.env.DB_CONNECTION;
const PORT = process.env.PORT;

app.use(bodyParser.json({ limit: "30mb", extended: true }));
app.use(bodyParser.urlencoded({ limit: "30mb", extended: true }));
app.use(cors());

mongoose
  .connect(DB_CONNECTION)
  .then(() =>
    app.listen(PORT, () => console.log(`Server is running on port ${PORT}`))
  )
  .catch((err) => console.log(error.message));
