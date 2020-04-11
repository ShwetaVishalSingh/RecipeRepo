import {store} from "react-notifications-component";

export default function showNotification(title, message, type) {
    store.addNotification({
        title: title,
        message: message,
        type: type,
        insert: "top",
        container: "top-right",
        animationIn: ["animated", "fadeIn"],
        animationOut: ["animated", "fadeOut"],
        dismiss: {
            duration: 10000,
            onScreen: true
        }
    });
}
