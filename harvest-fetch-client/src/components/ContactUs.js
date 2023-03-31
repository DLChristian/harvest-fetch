import { Link } from "react-router-dom";

function ContactUs() {
    return (
        <>
            <div class="">
                <section class="">
                    <div class="">FAQ</div>
                    <div class="">Answers to some of the questions frequently asked of us.</div>
                    <div>
                        <button><Link class="nav-link" to="/faw">Visit FAQ</Link></button>
                    </div>
                </section>
                <section class="">
                    <div class="">Problem With The Service?</div>
                    <div class="">For any issues with Harvest Fetch's service as a customer or farmer, let us know so that we may help!</div>
                    <div>
                        <button>
                            <a href="mailto:info@harvestfetch.com" class="button">Email Us</a>
                        </button>
                    </div>
                </section>
            </div>
        </>
    );
}

export default ContactUs;