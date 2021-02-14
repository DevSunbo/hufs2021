import React, {useState} from 'react';
import Select from 'react-select';
import styled from 'styled-components';
import {Container, Row, Col, Form, Button, Dropdown, FormControl, ListGroup} from 'react-bootstrap';
import Header from "../components/Header";
import {Link} from "react-router-dom";

const AdminAssetSidebar = () => {
    return (
        <Col md={{span: 3}}>
            <div className="border text-center">
                <div>기자재</div>
                <div className="align-self-center">
                    <div className="text-danger"><Link to="/admin/asset/register">기자재등록</Link></div>
                    <div className="mt-3"><Link to="/admin/asset/manage">기자재관리</Link></div>
                    <div className="mt-3"><Link to="/admin/asset/history">기자재히스토리</Link></div>
                    <div className="mt-3"><Link to="/admin/asset/rent">기자재대여</Link></div>
                    <div className="mt-3"><Link to="/admin/asset/category">카테고리</Link></div>
                </div>
            </div>
        </Col>
    );
}

export default AdminAssetSidebar;