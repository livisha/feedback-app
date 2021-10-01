import logo from './m_w.png';

const Navbar = () => {
    return (
        <nav className="navbar">
            <a href="/">
                <img src={logo} alt="AAI"/>
            </a>
        </nav>
    );
}

export default Navbar;