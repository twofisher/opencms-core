package com.opencms.core;

/**
 * This interface is a pool for cms-constants. All classes may implement this
 * class to get access to this contsnats.
 * 
 * @author Andreas Schouten
 * @version $Revision: 1.5 $ $Date: 1999/12/14 12:15:33 $
 */
public interface I_CmsConstants
{
	/**
	 * The version-string for the cvs.
	 */
	 static String C_VERSION = "Release 3.01 \"pre Caladan Leto\" $Name:  $";

	/**
	 * This flag is set for enabled entrys in the database.
	 * (GROUP_FLAGS for example)
	 */
	 static final int C_FLAG_ENABLED = 0;
	
	/**
	 * This flag is set for disabled entrys in the database.
	 * (GROUP_FLAGS for example)
	 */
	 static final int C_FLAG_DISABLED = 1;
	
	/**
	 * The resource type-id for a folder.
	 */
	 final static int C_TYPE_FOLDER		= 0;
	
	/**
	 * The resource type-id for a plain text file.
	 */
	 final static int C_TYPE_TEXTPLAIN		= 1;
	
	/**
	 * The resource type-id for a binary file.
	 */
	 final static int C_TYPE_BINARY		= 2;
	
	/**
	 * The resource type-id for a xml base file.
	 */
	 final static int C_TYPE_XMLBASE		= 3;

	/**
	 * The resource type-id for a xml templatefile.
	 */
	 final static int C_TYPE_XMLTEMPLATE	= 4;
	
	/**
	 * The resource type-id for a docloader file.
	 */
	 final static int C_TYPE_DOCLOADER	= 5;
	
	/**
	 * This constant signs a normal "classic" metadefinition.
	 */
	static final int C_METADEF_TYPE_NORMAL		= 0;

	/**
	 * This constant signs a optional metadefinition.
	 * These metadefinitions will be shown at creation-time for a resource.
	 * They may be filled out by the user.
	 */
	static final int C_METADEF_TYPE_OPTIONAL	= 1;

	/**
	 * This constant signs a mandatory metadefinition.
	 * These metadefinitions will be shown at creation-time for a resource.
	 * They must be filled out by the user, else the resource will not be created.
	 */
	static final int C_METADEF_TYPE_MANDATORY	= 2;

	/**
	 * This is the group for guests.
	 */
	 static final String C_GROUP_GUEST = "Guests";
	
	/**
	 * This is the group for administrators.
	 */
	 static final String C_GROUP_ADMIN = "Administrators";
	
	/**
	 * This is the group for projectleaders. It is the only group, which
	 * can create new projects.
	 */
	 static final String C_GROUP_PROJECTLEADER = "Projectleader";

	/**
	 * Key for additional info emailaddress.
	 */
	 final static String C_ADDITIONAL_INFO_EMAIL		= "USER_EMAIL";

	/**
	 * Key for additional info firstname.
	 */
	 final static String C_ADDITIONAL_INFO_FIRSTNAME	= "USER_FIRSTNAME";

	/**
	 * Key for additional info surname.
	 */
	 final static String C_ADDITIONAL_INFO_LASTNAME	= "USER_LASTNAME";

	/**
	 * Key for additional info address.
	 */
	 final static String C_ADDITIONAL_INFO_ADDRESS	= "USER_ADDRESS";

	/**
	 * Key for additional info section.
	 */
	 final static String C_ADDITIONAL_INFO_SECTION	= "USER_SECTION";
     
     /**
	 * Key for additional info default group.
	 */
	 final static String C_ADDITIONAL_INFO_DEFAULTGROUP	= "USER_DEFAULTGROUP";
     
     /**
	 * Key for additional info last login.
	 */
	 final static String C_ADDITIONAL_INFO_LASTLOGIN	= "USER_LASTLOGIN";

     /**
	 * Key for additional info flags.
	 */
	 final static String C_ADDITIONAL_INFO_FLAGS	= "USER_FLAGS";
     
	/**
	 * This constant is used to order the tasks by date.
	 */
	 static final int C_ORDER_BY_DATE =		1;

	/**
	 * This constant is used to order the tasks by name.
	 */
	 static final int C_ORDER_BY_NAME =		2;
	
	// TODO: add order-criteria here.

	/**
	 * This constant defines the onlineproject. This is the project which
	 * is used to show the resources for guestusers
	 */
	 static final String C_PROJECT_ONLINE	= "Live";
	
	/**
	 * This constant defines a unlocked project. 
	 * Resources may be changed in this project.
	 */
	 static final int C_STATE_UNLOCKED			= 0;

	/**
	 * This constant defines a locked project.
	 * Resources can't be changed in this project.
	 */
	 static final int C_STATE_LOCKED			= 1;

	/**
	 * This constant defines a project in a archive.
	 * Resources can't be changed in this project. Its state will never
	 * go back to the previos one.
	 */
	 static final int C_STATE_ARCHIVE			= 2;

	/**
	 * This id will be returned for resources with no id.
	 * (filesystem resources)
	 */
	 final static int C_UNKNOWN_ID		= -1;

	/**
	 * Owner may read this resource
	 */
	 final static int C_ACCESS_OWNER_READ		= 1;

	/**
	 * Owner may write this resource
	 */
	 final static int C_ACCESS_OWNER_WRITE		= 2;
	
	/**
	 * Owner may view this resource
	 */
	 final static int C_ACCESS_OWNER_VISIBLE		= 4;
	
	/**
	 * Group may read this resource
	 */	
	 final static int C_ACCESS_GROUP_READ		= 8;
	
	/**
	 * Group may write this resource
	 */
	 final static int C_ACCESS_GROUP_WRITE		= 16;
	
	/**
	 * Group may view this resource
	 */
	 final static int C_ACCESS_GROUP_VISIBLE		= 32;
	
	/**
	 *  may read this resource
	 */	
	 final static int C_ACCESS_PUBLIC_ACCESS_READ		= 64;
	
	/**
	 *  may write this resource
	 */	
	 final static int C_ACCESS_PUBLIC_ACCESS_WRITE		= 128;

	/**
	 *  may view this resource
	 */
	 final static int C_ACCESS_PUBLIC_ACCESS_VISIBLE	= 256;

	/**
	 * This is an internal resource, it can't be launched directly.
	 */
	 final static int C_ACCESS_INTERNAL_READ		= 512;
	
	/**
	 * All may read this resource.
	 */
	 final static int	C_ACCESS_READ				= C_ACCESS_OWNER_READ + C_ACCESS_GROUP_READ + C_ACCESS_PUBLIC_ACCESS_READ;

	/**
	 * All may write this resource.
	 */
	 final static int	C_ACCESS_WRITE				= C_ACCESS_OWNER_WRITE + C_ACCESS_GROUP_WRITE + C_ACCESS_PUBLIC_ACCESS_WRITE;
	
	/**
	 * All may view this resource.
	 */
	 final static int	C_ACCESS_VISIBLE			= C_ACCESS_OWNER_VISIBLE + C_ACCESS_GROUP_VISIBLE + C_ACCESS_PUBLIC_ACCESS_VISIBLE;
	
	/**
	 * Owner has full access to this resource.
	 */
	 final static int C_ACCESS_OWNER				= C_ACCESS_OWNER_READ + C_ACCESS_OWNER_WRITE + C_ACCESS_OWNER_VISIBLE;

	/**
	 * Group has full access to this resource.
	 */
	 final static int C_ACCESS_GROUP				= C_ACCESS_GROUP_READ + C_ACCESS_GROUP_WRITE + C_ACCESS_GROUP_VISIBLE;

	/**
	 *  has full access to this resource.
	 */
	 final static int C_ACCESS_			= C_ACCESS_PUBLIC_ACCESS_READ + C_ACCESS_PUBLIC_ACCESS_WRITE + C_ACCESS_PUBLIC_ACCESS_VISIBLE;
	
	/**
	 * The default-flags for a new resource.
	 */
	 final static int C_ACCESS_DEFAULT_FLAGS		= C_ACCESS_OWNER_READ + C_ACCESS_OWNER_WRITE + C_ACCESS_OWNER_VISIBLE + C_ACCESS_GROUP_READ + C_ACCESS_GROUP_WRITE + C_ACCESS_GROUP_VISIBLE + C_ACCESS_PUBLIC_ACCESS_READ + C_ACCESS_PUBLIC_ACCESS_VISIBLE;
	
	/**
	 * Is set, if the resource is unchanged in this project.
	 */
	 static final int C_STATE_UNCHANGED	= 0;

	/**
	 * Is set, if the resource was changed in this project.
	 */
	 static final int C_STATE_CHANGED		= 1;
	
	/**
	 * Is set, if the resource is new in this project.
	 */	
	 static final int C_STATE_NEW			= 2;
	
	/**
	 * Is set, if the resource was deleted in this project.
	 */	
	 static final int C_STATE_DELETED		= 3;
     
     /**
      * This value will be returned for int's withaout a value.
      */
     static final int C_UNKNOWN_INT         = -1;
     
     /**
      * This value will be returned for long's withaout a value.
      */
     static final int C_UNKNOWN_LONG        = -1;  
  
        
}
