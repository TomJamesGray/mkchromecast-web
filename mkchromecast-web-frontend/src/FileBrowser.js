// import {useParams} from "react-router";
import { BASE_FILE_API_URL} from "./constants";
import {useEffect, useState} from "react";
import {useParams} from "react-router";

function FileBrowser() {
    const reqPath = useParams()["*"];
    console.log("Rendering")
    console.log(BASE_FILE_API_URL)
    const [data, setData] = useState("");
    const [isLoading, setIsLoading] = useState(true)
    useEffect(() =>{
        fetch(BASE_FILE_API_URL + reqPath)
            .then(res => res.json())
            .then((result) => {
                setIsLoading(false)
                setData(result)
                console.log(result);
            })
    },[]);
    if (isLoading) {
        return <h1>Wait</h1>
    }else{
        return (
            <ul>{
                data.map((item,id) => (
                    <li key={id}>{item}</li>
                ))
            }</ul>
        )
    }
}

export default FileBrowser;