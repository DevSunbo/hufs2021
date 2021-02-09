import React, { useState, useEffect } from 'react';
import axios from 'axios';

export let handler;
handler = async (event) => {
    const response = {
        statusCode: 200,
        headers: {
            "Access-Control-Allow-Headers" : "Content-Type",
            "Access-Control-Allow-Origin": "https://www.example.com",
            "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
        },
        body: JSON.stringify('Hello from Lambda!'),
    };
    return response;
};

function Users() {
    const [users, setUsers] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchUsers = async () => {
            try {
                // 요청이 시작 할 때에는 error 와 users 를 초기화하고
                setError(null);
                setUsers(null);
                // loading 상태를 true 로 바꿉니다.
                setLoading(true);

                const response = await axios.get(

                    /*{'access-control-allow-origin':'http://localhost:8080/api/userinfo',
                        "Access-Control-Allow-Headers" : "Content-Type",
                        "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
                    }*/
                    // 'https://jsonplaceholder.typicode.com/users'
                    //{'access-control-allow-origin':'http://localhost:8080/api/userinfo'}
                    'http://localhost:8080/api/userinfo'
                );
                console.log("response : " + response)
                console.log(response.data)
                setUsers(response.data); // 데이터는 response.data 안에 들어있습니다.
            } catch (e) {
                setError(e);
            }
            setLoading(false);
        };

        fetchUsers();
    }, []);

    if (loading) return <div>로딩중..</div>;
    if (error) return <div>에러가 발생했습니다</div>;
    if (!users) return null;
    return (
        <ul>
            {users.map(user => (
                <li >
                    {user.name}
                </li>
            ))}
        </ul>
    );
}

export default Users;
//{'access-control-allow-origin':'http://localhost:8080/api/userinfo'}