# film-tracker
Mobile app for keeping track of your vintage cameras and what film they're loaded with

# Description
One of the challenges of collecting vintage cameras is remembering what film you have loaded in each camera.  Many cameras have indicators to help you remember, but they don’t always map to modern films.  This tool is for keeping track of your rolls of film, from loading all the way through developing.

# Design
- login screen
- tab for cameras (default)
    - list all cameras and current state
    - order by most recently changed
    - add a camera
        - camera details
    - show camera details for existing camera
    - update notes for current roll
    - change film state for camera
        - load (pick film)
            - add film type
        - finish roll
            - update notes
- tab for rolls
    - state of each roll
    - sort rolls with loaded first, then finished, then sent, then developed, then imported.  within, sort by timestamp of state changed)
    - filter for state, camera, iso, date
    - add photos (import from zip / darkroom or associate with google photos)
- tab for photos
    - add photos (pick roll, import from zip / darkroom or associate with google photos)
    - photo browser that links to google photos
    - show thumbnails
    - filter by camera, film, iso, rating, roll, date
- add family member
    - enter email address
    - other user accepts invite
    - shares all data between the two users
