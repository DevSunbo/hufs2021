import React from 'react';
import { Col } from 'react-bootstrap';
import {Link} from "react-router-dom";

const AssetSidebar = () => {
    return (
        <Col md={{span: 3}}>
            <div className="border text-center">
                <div>기자재</div>
                <div className="align-self-center">
                    <div className="text-danger"><Link to="/asset">기자재조회</Link></div>
                    <div className="mt-3"><Link to="/asset/apply">기자재신청</Link></div>
                </div>
            </div>
        </Col>
    );
}

export default AssetSidebar;