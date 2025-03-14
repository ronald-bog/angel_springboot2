import { useState } from "react";

function Header() {

    const [login, setLogin] = useState(1);

    return (
        <>
            <h1>HEADER</h1>
            <div>{login ?
                <h3>AUTENTICADO</h3> :
                <h3>SIN LOGIN</h3>
            }</div>
        </>
    );
}

export default Header;