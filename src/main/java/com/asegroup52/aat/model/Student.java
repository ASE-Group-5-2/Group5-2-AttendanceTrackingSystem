/**
 * Copyright 2014-2015 Google Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//[START all]
package com.asegroup52.aat.model;

import com.asegroup52.aat.tools.OfyHelper;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.lang.String;
import java.util.Date;

/**
 * The @Entity tells Objectify about our entity.  We also register it in {@link OfyHelper}
 * Our primary key @Id is set automatically by the Google Datastore for us.
 *
 * We add a @Parent to tell the object about its ancestor. We are doing this to support many
 * guestbooks.  Objectify, unlike the AppEngine library requires that you specify the fields you
 * want to index using @Index.  Only indexing the fields you need can lead to substantial gains in
 * performance -- though if not indexing your data from the start will require indexing it later.
 *
 * NOTE - all the properties are PUBLIC so that we can keep the code simple.
 **/
@Entity
public class Student {
    @Id public String id;
    public Key<Group> group;
    public String email;
    public String nickname;
    public Date date;

    /**
     * Simple constructor just sets the date
     **/
    public Student() {
        date = new Date();
    }

    /**
     * A convenience constructor
     **/
    public Student(String student_id, String student_email, String nickname) {
        this();
        this.id = student_id;
        this.email = student_email;
        this.nickname = nickname;
    }

    public Student(String student_id, String student_email, String nickname, String group) {
        this();
        this.id = student_id;
        this.email = student_email;
        this.nickname = nickname;
        this.group = Key.create(Group.class, group);
    }

}
//[END all]
