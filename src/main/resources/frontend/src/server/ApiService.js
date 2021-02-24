import axios from "axios"

const ApiService = () => {
    const fetchAssets = () => {
        return axios.get("http://localhost:8080/api/asset/test/read")
    }
}

export default ApiService;