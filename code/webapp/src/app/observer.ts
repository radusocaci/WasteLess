import {Notification} from "./notification";

export interface Observer {

  notify(notification: Notification): void;
}
