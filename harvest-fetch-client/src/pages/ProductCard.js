import { useContext } from "react";
import { CartContext } from "../contexts/CartContext";


export default function ProductCard({product}){
    const { addItemToOrder } = useContext(CartContext);

    const handleAddToCart = () => {
        addItemToOrder({
            productId: product.productId,
            productName: product.productName,
            //price: product.farmerProduct.price,
            quantity: 1,
           
        });
    };

    return (
        <div className="col container-product">
            <svg className="plus" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" onClick={handleAddToCart}><path d="M256 512A256 256 0 1 0 256 0a256 256 0 1 0 0 512zM232 344V280H168c-13.3 0-24-10.7-24-24s10.7-24 24-24h64V168c0-13.3 10.7-24 24-24s24 10.7 24 24v64h64c13.3 0 24 10.7 24 24s-10.7 24-24 24H280v64c0 13.3-10.7 24-24 24s-24-10.7-24-24z"/></svg>
            <div className="card">
                {product.product.pictureUrl && <img src={product.product.pictureUrl} className="card-img-top" alt={product.product.productName} />}
                <div className="card-body">
                <p className="card-text">
                    {product.product.productName}
                </p>
                </div>
            </div>
        </div>
    )

}