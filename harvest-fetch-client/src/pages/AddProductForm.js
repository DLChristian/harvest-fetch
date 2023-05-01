import { getEmtpyFarmerProduct, save } from "../services/farmerProductService"
import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { findAll } from "../services/productService"

export default function AddProductForm({farmer}){
    const [product, setProduct] = useState();
    const [farmerProduct, setFarmerProduct] = useState(getEmtpyFarmerProduct())
    const [error, setErrors] = useState([]);
    const [wait, setWait] = useState(true);

    const navigate = useNavigate();
    const { id } = useParams();

    const [products, setProducts] = useState([])

    useEffect(() => {
        findAll()
        .then(setProducts)
        .catch(() => navigate("/500"));
    }, [navigate])

    function cancel(){
        navigate("/");
    }

    function onChange(evt) {
        const nextProduct = {...product}
        nextProduct[evt.target.name] = evt.target.value;
        setProduct(nextProduct);
    }

    function handleSubmit(evt){
        evt.preventDefault();
        save(product);
    }

    return (
        <div></div>
        // <form onSubmit={handleSubmit}>
        //     <div>
        //         <label htmlFor="productName" className="form-label">Product Name</label>
        //         <input type="text" id="productName" name="productName" className="form-control"
        //             value={product.productName} onChange={onChange} />
        //     </div>
        //     <div>
        //         <label htmlFor="productUrl" className="form-label">Picture Url</label>
        //         <input type="text" id="productUrl" name="productUrl" className="form-control"
        //             value={product.pictureUrl} onChange={onChange} />
        //     </div>
        //     <div>
        //         <label htmlFor="price" className="form-label">Price</label>
        //         <input type="decimal" id="price" name="pricel" className="form-control"
        //             value={product.price} onChange={onChange} />
        //     </div>
        //     <div className="mt-2">
        //         <button type="submit" className="btn btn-primary me-2">Save</button>
        //         <button onClick={cancel} type="button" className="btn btn-warning">Cancel</button>
        //     </div>
        // </form>
    )
}