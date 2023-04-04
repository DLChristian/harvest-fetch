export default function Farmer({farmer}){
    return (
        <div className="col">
            <div className="card">
                {farmer.photoUrl && <img src={farmer.imageUrl} className="card-img-top" alt={farmer.farmName} />}
                <div className="card-body">
                    <div className="row">
                        <h5 className="card-title col">{farmer.farmName}</h5>
                    </div>
                </div>
                <p className="card-text">
                    {farmer.details}
                </p>
            </div>
        </div>
    )
}