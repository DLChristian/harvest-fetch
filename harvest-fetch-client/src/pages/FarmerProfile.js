import "../components/test/FarmerProfileTestStyles.css";
import { useParams } from 'react-router-dom';
import { useEffect, useState } from "react";
import UserInfo from "./UserInfo";
import { findById } from "../services/farmerService";
import ProductCard from "./ProductCard";
import { useNavigate } from "react-router-dom";

export default function FarmerProfile(){
    const [farmer, setFarmer] = useState([])
    // const [products, setProducts] = useState([])
    
    const { farmerId } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        if (farmerId) {
            findById(farmerId)
            .then(farmer => {
                console.log(farmer)
                setFarmer(farmer)
            })
            .catch(() => navigate("/500"))
        }
    }, []);

    // useEffect(() => {
    //     if (farmerId.userId) {
    //         findById(farmerId.userId)
    //         .then(setUser)
    //         .catch(() => navigate("/500"))
    //     }
    // }, []);

    return (
        <>
            <body className="profileBody">
                <div className="full">
                    <section id="profile">
                        <div className="name">{farmer.farmName}</div>
                        <div className="img">
                        {farmer.photoUrl && <img src={farmer.photoUrl} alt={farmer.farmName} />}
                        </div>
                        <section id="info" className="info">
                            <div class="row">
                                <div class="column">
                                    <ul>
                                        <li><span className="label">Address: </span></li>
                                        <li><span className="label">City: </span></li>
                                        <li><span className="label">State: </span></li>
                                        <li><span className="label">Zip Code: </span></li>
                                        <li><span className="label">Email: </span></li>
                                        <li><span className="label">Phone: </span></li>
                                    </ul>
                                </div>
                                <UserInfo />
                            </div>
                        </section>
                        <div className="subtitle">Details</div>
                        <section className="details">
                            <div class="boxa">{farmer.details}</div>
                        </section>
                    </section>
                    <section id="inventory">
                        <div className="name">Inventory</div>
                        <div className="boxb">
                            {farmer && farmer.products && farmer.products.map(p => <ProductCard key={p.productId} product={p} />)}
                        </div>
                    </section>
                </div>
            </body>
        </>
    );
}