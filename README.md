# The ParcelScout project

The ParcelScout is a project to create sample integration platforms using different technologies
(Spring MVC, Java EE, Rails), just to check how same problems are solved for different platforms.

ParcelScout is a hypothetical platform providing interface for package localization. The exact
package position are provided by several carriers, and ParcelScout integrates all carrier infrastructures
into one, public API.

Each carrier infrastructure will be created in different technology, as well as ParcelScout application
will be done using several approaches, just to check how same problems are solved in different
frameowrks.

## Architecture

To see, how the general architecture looks like please refer to ``doc/diagrams/`` directory, and
check available diagrams (which are created during the development). Note that the code might
slightly differ to given diagrams, depending on the problems I've encounter and other factors (i.e.
for SPU application the planned response type was JSON, however JSON/XML format negotiation
was implemented using Spring MVC support).