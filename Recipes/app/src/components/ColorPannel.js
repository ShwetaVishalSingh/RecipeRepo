import React from 'react'

const ColorPannel = () => {
    return(
        <section id="color-panel" className="close-color-panel">
            <a className="panel-button gray2"><i className="fa fa-cog fa-spin fa-2x"></i></a>
            <div className="segment">
                <h4 className="gray2 normal no-padding">Color Scheme</h4>
                <a title="orange" className="switcher orange-bg"></a>
                <a title="strong-blue" className="switcher strong-blue-bg"></a>
                <a title="moderate-green" className="switcher moderate-green-bg"></a>
                <a title="vivid-yellow" className="switcher vivid-yellow-bg"></a>
            </div>
        </section>
    )
};
export default ColorPannel
