import "../components/test/FarmerProfileTestStyles.css";
import { useParams } from 'react-router-dom';

export default function FarmerProfile({farmer}){
    const { id } = useParams();
    return (
        <>
            <body className="profileBody">
                <div className="full">
                    <section id="profile">
                        <div className="name">Alpine Ridge</div>
                        <div className="img">
                            <img src="https://images.squarespace-cdn.com/content/v1/5a7874cabe42d6cd6a7dca35/1517858230310-UFO302OSS2ZCEOGCHK0Z/fazenda-santa-ines-5.jpg" />
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
                                <div class="columnb">
                                    <ul>
                                        <li><span className="entry">123 Main St.</span></li>
                                        <li><span className="entry">Memphis</span></li>
                                        <li><span className="entry">TN</span></li>
                                        <li><span className="entry">38118</span></li>
                                        <li><span className="entry">alpineridge@alpine.com</span></li>
                                        <li><span className="entry">9015551234</span></li>
                                    </ul>
                                </div>
                            </div>
                        </section>
                        <div className="subtitle">Details</div>
                        <section className="details">
                            <div class="boxa">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                        </section>
                    </section>
                    <section id="inventory">
                        <div className="name">Inventory</div>
                        <div className="boxb">

                        </div>
                    </section>
                </div>
            </body>
        </>
    );
}