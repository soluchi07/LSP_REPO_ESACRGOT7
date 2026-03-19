# CRC Collaboration Explanation

TaskManager collaborates with Task because its responsibilities—storing, locating, and filtering tasks—require it to directly create, access, and inspect Task objects. Task, however, is only responsible for storing its own data and updating its status; it does not need to know about the collection it belongs to in order to fulfill those responsibilities, so it has no dependency on TaskManager.
