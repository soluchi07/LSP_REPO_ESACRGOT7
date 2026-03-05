### Problem (given)
A small country is building an ATC (air traffic control) system for its single airport.
- Every arriving aircraft has a transponder that broadcasts aircraft type & flight data in a high‑density packet format.
- The ATC ground station receives, unpacks, and stores the data in an aircraft database.
- A graphics display is built from the stored info and updated every 10 seconds for the controller.
- The system analyzes information to detect dangerous situations.
- The controller can query the database for details about any plane on screen.

Task: Use CRC (Class-Responsibility-Collaboration) to design this system. You are required to produce a set of CRC cards only.

### Possible Classes Needed:
- Transponder
  - responsibilities: reads aircraft type and flight data from Aircraft, formats and distributes flight and aricraft data
  - `format_flight_data(flight_code)`: calls `get_flight_data()`, calls `get_aircraft_type()`, formats it to "high‑density packet" and returns
  - collaborators: Aircraft, Ground_Receiver

- Aircraft
  - responsibilities: has aircraft type & flight data (aircraft code, flight data, etc...)
  - flight data is an instance variable that's a list of hashmaps of the form `{"fight code": 000, "time":..., "aircraft_code":...}`
  - `get_flight_data(code)`: iterates through list to find map with fight_code == code
  - `get_aircraft_type()`: returns aircraft type
  - collaborators: N/A

- Ground_Receiver
  - Resonsibilities: receive broadcast packets from Transponder, detect valid transponder signals, forward received packets for unpacking
  - Collaborators: Transponder, PacketProcessor

- PacketProcessor
  - Resonsibilities: unpack high-density data packets, extract aircraft flight information, validate and format data before storage
  - collaborators: Ground_Receiver, Database

- Database
  - responsibilities: stores aircraft flight data, update aircraft information as new data arrives, provide aircraft data for display and queries
  - collaborators: PacketProcessor, Display, Controller, Safety_Analyzer

- Display
  - collaborators: Database, Controller
  - responsibilities: retrieve aircraft info from database, visually display of aircraft positions, update controller every 10s
  - `get_flight_info()`: retrieves most up-to-date info from database
  - show_display(): shows most recently retrieved info
  - update_display(): calls get_flight_info() and show_display()

- Safety_Analyzer
  - Resonsibilities: analyze aircraft data for dangerous situations, detect conflicts (e.g., proximity, collision risk), alert controller when hazards are detected
  - Collaborators: Database, Controller
  - assess_danger(): retrieves info from Database, checks data againsts baselines, if safe: print ("All Systems Stable"), otherwise call alert_controller()
  - alert_controller(): alerts Controller of specific safety issue

- Controller
  - Resonsibilities: queries aircraft details, display warnings and aircraft information, makes controller commands or requests
  - collaborators: Database, Safety_Analyzer, Display
  - get_details(aircraft_code): query the database for details about any plane on screen.


### Solution
Class: **Aircraft**

Responsibilities:

* Maintain aircraft identity and type
* Maintain current flight data
* Provide aircraft information when requested

Collaborators (if any):

* Transponder

Assumptions (if any):

* Each aircraft has a transponder installed
* Aircraft flight data is continuously updated

---

Class: **Transponder**

Responsibilities:

* Collect aircraft type and flight data
* Encode aircraft information into high-density packets
* Broadcast encoded packets to the ground station

Collaborators (if any):

* Aircraft
* Ground Receiver

Assumptions (if any):

* Transponders periodically broadcast aircraft data

---

Class: **Ground Receiver**

Responsibilities:

* Receive broadcast packets from aircraft transponders
* Detect and validate incoming signals
* Forward received packets for processing

Collaborators (if any):

* Transponder
* Packet Processor

Assumptions (if any):

* The receiver can handle multiple incoming aircraft signals

---

Class: **Packet Processor**

Responsibilities:

* Unpack high-density data packets
* Extract aircraft flight information
* Validate and format data before storage

Collaborators (if any):

* Ground Receiver
* Database

Assumptions (if any):

* Packets follow a known high-density format

---

Class: **Database**

Responsibilities:

* Store aircraft flight data
* Update aircraft records when new data arrives
* Provide aircraft data for system components

Collaborators (if any):

* Packet Processor
* Display
* Controller
* Safety Analyzer

Assumptions (if any):

* Each aircraft record can be uniquely identified

---

Class: **Display**

Responsibilities:

* Retrieve aircraft information from the database
* Construct a graphical display of aircraft positions
* Update the controller’s display every 10 seconds

Collaborators (if any):

* Database
* Controller

Assumptions (if any):

* The display refresh cycle is fixed at 10 seconds

---

Class: **Safety Analyzer**

Responsibilities:

* Analyze aircraft data for dangerous situations
* Detect potential aircraft conflicts
* Notify the controller when hazards are detected

Collaborators (if any):

* Database
* Controller

Assumptions (if any):

* Safety rules exist for determining dangerous situations

---

Class: **Controller**

Responsibilities:

* Query aircraft information
* Request detailed information about aircraft on screen
* Receive safety alerts and warnings

Collaborators (if any):

* Database
* Display
* Safety Analyzer

Assumptions (if any):

* The controller interacts with the system through the display interface

<style>
  h3{
    text-decoration: underline;
  }
</style>