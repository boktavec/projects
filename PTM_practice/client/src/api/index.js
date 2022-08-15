import axios from "axios";
import "../../dotenv/config";

const PORT = process.env.PORT;
const url = `http://localhost:${PORT}/posts`;

export const fetchPosts = () => axios.get(url);
