export default function ProductCard({product}){

    return (
        <div className="col">
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