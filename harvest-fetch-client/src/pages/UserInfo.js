import "../components/test/FarmerProfileTestStyles.css";
import { useEffect, useState } from "react";
import { findById } from "../services/appUserInfoService";
import { useNavigate } from "react-router-dom";

export default function UserInfo({userId}){
    const [user, setUser] = useState([])
    const navigate = useNavigate();

    useEffect(() => {
        if (userId) {
            findById(userId)
            .then(user => {
                console.log(user)
                setUser(user)
            })
            .catch(() => navigate("/500"))
        }
    }, []);
    
    return (
        <div class="columnb">
            <ul>
                <li><span className="entry">{user.address}</span></li>
                <li><span className="entry">Memphis</span></li>
                <li><span className="entry">TN</span></li>
                <li><span className="entry">38118</span></li>
                <li><span className="entry">alpineridge@alpine.com</span></li>
                <li><span className="entry">9015551234</span></li>
            </ul>
        </div>
    );
}