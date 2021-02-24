import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Assets = () => {
    const [assets, setAssets] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const getMyData = async () => {
        const data = await axios.get('localhost:8080/api/asset/test/read');
        console.log('data is ' + JSON.stringify(data));
    };
    useEffect(() => {
        const fatchAssets = async () => {
            try {
                // 요청이 시작 할 때에는 error 와 users 를 초기화하고
                setError(null);
                setAssets(null);
                // loading 상태를 true 로 바꿉니다.
                setLoading(true);
                let response = await axios.get(
                    'localhost:8080/api/asset/test/read'
                );

                setAssets(response.data); // 데이터는 response.data 안에 들어있습니다.
            } catch (e) {
                setError(e);
            }
            setLoading(false);
        };

        fatchAssets();
    }, []);

    if (loading) return <div>로딩중..</div>;
    if (error) return <div>에러가 발생했습니다</div>;
    if (!assets) return null;
    return (
        <ul>
            {assets.map(user => (
                <li key={user.id}>
                    {user.name}
                </li>
            ))}
        </ul>
    );
}

export default Assets;