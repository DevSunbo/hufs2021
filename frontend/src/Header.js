import React, {useState, useEffect} from 'react'
import axios from "axios";

function Header(){
    const [user, setUser] = useState(null)  ;
    useEffect(() => {
        const fetchUser = async () => {
            try{
                const response = await axios.get(
                    ''
                );
                setUser(response.data);
            } catch (e){

            }
        };
        fetchUser();
    }, []);
    return (
        <ul>
            {user.map(user => <li key={user.studentId}>
                {user.name}
            </li>)}

        </ul>
    );
}