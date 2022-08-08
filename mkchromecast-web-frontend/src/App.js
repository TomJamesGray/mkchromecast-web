import {BrowserRouter, Routes, Route} from "react-router-dom";
import FileBrowser from "./FileBrowser";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <Routes>
              <Route path="files/*" element={<FileBrowser/>}/>
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
