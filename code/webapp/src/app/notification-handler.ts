import {Observer} from "./observer";
import {Notification} from "./notification";

export class NotificationHandler implements Observer {

  get msg(): string {
    return this._msg;
  }

  private _msg: string;

  constructor() {
  }

  notify(notification: Notification): void {
    this._msg = notification.message;
  }
}
